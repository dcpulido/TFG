from os import listdir, system
from os.path import isdir, join
import logging


class Compiler:
    def __init__(self, genconf, compconf):
        self.generatorconf = genconf
        print genconf
        self.compilerconf = compconf
        self.compile_cmd = "ant compile"
        self.run_cmd = "ant runide"
        self.code_dir = "../" + \
            self.compilerconf["env"] + \
            "/src/ingenias/editor"
        self.env_dir = "../" + self.compilerconf["env"]
        self.refresh_sources()

    def refresh_sources(self):
        self.sources = [f for f in listdir(self.generatorconf["output"])
                        if isdir(join(self.generatorconf["output"], f))]

    def clean_env(self):
        try:
            print "rm -Rf " + self.code_dir
            system("rm -Rf " + self.code_dir)
        except Exception:
            logging.info("ERROR on clean env")

    def compile(self, source):
        system("cp -r " +
               self.generatorconf["output"] +
               "/" +
               source +
               " " +
               self.code_dir)
        system("cd " +
               self.env_dir +
               "&& echo $PWD &&" +
               self.compile_cmd)


if __name__ == "__main__":
    cmp = Compiler(dict(output="../source_output"),
                   dict(env="editor"))
    cmp.clean_env()
    cmp.compile("anonimo_filename")
