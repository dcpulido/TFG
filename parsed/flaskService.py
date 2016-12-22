class flaskApp(threading.Thread):
   def run(self):
      app.run()


app = Flask(__name__) 

@app.route("/")
def hello():
    return render_template('index.html', name=None)

@app.route('/shutdown', methods=['GET','POST'])
def shutdown():
    shutdown_server()
    return 'Server shutting down...'

@app.route("/parse", methods=['GET', 'POST'])
def parse_xml():
   logging.info("FLASK:parse_xml")
   if request.method == 'POST':

      ou= str(request.form.get('output'))
      inp=str(request.form.get('input'))
      au=str(request.form.get('autor'))

      logging.info("FLASK: "+ou+" "+inp+" "+au)
      init_the_parse(inp,ou,au)   
   return render_template('index.html')
def stop_flask():
    urllib2.urlopen("http://localhost:5000/shutdown").read()

def shutdown_server():
    func = request.environ.get('werkzeug.server.shutdown')
    if func is None:
        raise RuntimeError('Not running with the Werkzeug Server')
    func()
