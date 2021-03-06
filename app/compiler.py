from os import listdir, system
from os.path import isdir, join
from subprocess import Popen
import logging


class Compiler:
    def __init__(self,
                 genconf,
                 compconf,
                 ref="./"):
        self.generatorconf = genconf
        self.compilerconf = compconf
        self.compile_cmd = compconf["compile_cmd"]
        self.run_cmd = compconf["run_cmd"]
        self.ref = ref
        self.code_dir = self.ref + \
            self.compilerconf["env"] + \
            "/src/ingenias/editor"
        self.env_dir = self.ref + self.compilerconf["env"]
        self.refresh_sources()

    def get_profiles(self):
        self.refresh_sources()
        return self.sources

    def refresh_sources(self):
        self.sources = [f for f in listdir(self.generatorconf["output"])
                        if isdir(join(self.generatorconf["output"], f))]

    def clean_env(self):
        try:
            system("rm -Rf " +
                   self.generatorconf["output"] +
                   "/*")
        except Exception:
            logging.info("ERROR on clean env")

    def remove_prof(self, source):
        try:
            logging.info("BORRANDO " + source)
            logging.info("rm -Rf " +
                         self.generatorconf["output"] +
                         "/" +
                         source)
            system("rm -Rf " +
                   self.generatorconf["output"] +
                   "/" +
                   source)
        except Exception:
            logging.info("ERROR on clean env")

    def compile(self, source):
        logging.info("COMPILING: " + source)

        system("cp -r " +
               self.generatorconf["output"] +
               "/" +
               source +
               " " +
               self.code_dir)
        # system()
        an, cp = self.compile_cmd.split(" ")
        print "ENTRA"
        if self.compilerconf["xterm"] == "1":
            print "A 1"
            Popen(['xterm', '-e', an, cp, "2>", "out.txt"], cwd=self.env_dir+"/")
        else:
            print "A 0"
            system("cd " +
                   self.env_dir +
                   "&& echo $PWD &&" +
                   self.compile_cmd)
        # HERE RETURN SOMETHING

    def start_prof(self, source):
        logging.info("STARTING: " + source)
        an, cp = self.run_cmd.split(" ")
        if self.compilerconf["xterm"] == "1":
            Popen(['xterm', '-e', an, cp, "2>", "out.txt"], cwd=self.env_dir+"/")
        else:
            system("cd " +
                   self.env_dir +
                   "&& echo $PWD &&" +
                   self.run_cmd)


if __name__ == "__main__":
    cmp = Compiler(dict(output="../source_output"),
                   dict(env="editor"), "../")
    cmp.clean_env()
    cmp.compile("anonimo_filename")
