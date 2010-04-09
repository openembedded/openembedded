# Integration with the oestats build statistics server, see:
#
# http://opensource.bolloretelecom.eu/projects/oestats
#
# To make use of this class, add to your local.conf:
#
# INHERIT += "oestats-client"
# OESTATS_SERVER = "http://some.server.org"
# OESTATS_BUILDER = "some_nickname"
# 

def oestats_setid(d, val):
	import bb
	f = file(bb.data.getVar('TMPDIR', d, True) + '/oestats.id', 'w')
	f.write(val)

def oestats_getid(d):
	import bb
	f = file(bb.data.getVar('TMPDIR', d, True) + '/oestats.id', 'r')
	return f.read()
	
def oestats_send(d, server, action, vars = {}, files = {}):
	import bb
	import urllib2

	# build body
	output = []
	bound = '----------ThIs_Is_tHe_bouNdaRY_$'
	for key in vars:
		assert vars[key]
		output.append('--' + bound)
		output.append('Content-Disposition: form-data; name="%s"' % key)
		output.append('')
		output.append(vars[key])
	for key in files:
		assert files[key]
		output.append('--' + bound)
		output.append('Content-Disposition: form-data; name="%s"; filename="%s"' % (key, files[key]['filename']))
		output.append('Content-Type: %s' % files[key]['content-type'])
		
		output.append('')
		output.append(files[key]['content'])
	output.append('--' + bound + '--')
	output.append('')
	body = "\r\n".join(output)

	# build headers
	headers = {
		"User-agent": "oestats-client/0.5",
		"Content-type": "multipart/form-data; boundary=%s" % bound,
		"Content-length": str(len(body))}

	proxy	= bb.data.getVar('HTTP_PROXY', d, True )
	if (proxy):
		phl = urllib2.ProxyHandler({'http' : proxy})
		opener = urllib2.build_opener(phl)
		urllib2.install_opener(opener)

	actionURL = "%s%s" %(server, action)
	req = urllib2.Request(actionURL, body, headers);
	response = urllib2.urlopen(req)
	data = response.read()
	
	return data

def oestats_start(server, builder, d):
	import bb
	import os.path
	import re

	# send report
	id = ""
	try:
		data = oestats_send(d, server, "/builds/", {
			'builder': builder,
			'build_arch': bb.data.getVar('BUILD_ARCH', d, True),
			'metadata_branch': bb.data.getVar('METADATA_BRANCH', d, True),
			'metadata_revision': bb.data.getVar('METADATA_REVISION', d, True),
			'machine': bb.data.getVar('MACHINE', d, True),
			'distro': bb.data.getVar('DISTRO', d, True),
		})
		if re.match("^\d+$", data): id=data
	except:
		pass

	# save the build id
	if id:
		bb.note("oestats: build %s" % id)
	else:
		bb.note("oestats: error starting build, disabling stats")
	oestats_setid(d, id)

def oestats_stop(server, d, failures):
	import bb

	# retrieve build id
	id = oestats_getid(d)
	if not id: return

	# send report
	if failures > 0:
		status = "Failed"
	else:
		status = "Succeeded"		      

	try:
		response = oestats_send(d, server, "/builds/%s/" % id, {
			'status': status,
		})
		if status == 'Failed':
			bb.note("oestats: build failed, see %s%s" % (server, response))
	except:
		bb.note("oestats: error stopping build")

def oestats_task(server, d, task, status):
	import bb
	import glob
	import os.path
	import time

	# retrieve build id
	id = oestats_getid(d)
	if not id: return

	# calculate build time
	try:
		elapsed = time.time() - float(bb.data.getVar('OESTATS_STAMP', d, True))
	except:
		elapsed = 0
	
	# prepare files
	files = {}
	if status == 'Failed':
		logs = glob.glob("%s/log.%s.*" % (bb.data.getVar('T', d, True), task))
        	if len(logs) > 0:
			log = logs[0]
			files['log'] = {
				'filename': 'log.txt',
				'content': file(log).read(),
				'content-type': 'text/plain'}
	if task == 'do_package':
		qalog = "%s/log.qa_package" % bb.data.getVar('T', d, True)
		if os.path.exists(qalog):
			files['qalog'] = {
				'filename': 'qalog.txt',
				'content': file(qalog).read(),
				'content-type': 'text/plain'}
	
	# prepare report
	vars = {
		'build': id,
		'package': bb.data.getVar('PN', d, True),
		'version': bb.data.getVar('PV', d, True),
		'revision': bb.data.getVar('PR', d, True),
		'depends': bb.data.getVar('DEPENDS', d, True),
		'task': task,
		'status': status,
		'time': str(elapsed)}
	bug_number = bb.data.getVar('OESTATS_BUG_NUMBER', d, True)
	bug_tracker = bb.data.getVar('OESTATS_BUG_TRACKER', d, True)
	if bug_number and bug_tracker:
		vars['bug_number'] = bug_number
		vars['bug_tracker'] = bug_tracker

	# send report
	try:
		response = oestats_send(d, server, "/tasks/", vars, files)
		if status == 'Failed':
			bb.note("oestats: task failed, see %s%s" % (server, response))
	except:
		bb.note("oestats: error sending task, disabling stats")
		oestats_setid(d, "")

addhandler oestats_eventhandler
python oestats_eventhandler () {
	from bb.event import getName
	import bb
	import time

	if e.data is None or getName(e) == "MsgNote":
		return

	server = bb.data.getVar('OESTATS_SERVER', e.data, True)
	if not server.startswith('http://') and not server.startswith('https://'):
		server = "http://%s" %(server)
	builder = bb.data.getVar('OESTATS_BUILDER', e.data, True)
	if not server or not builder:
		return

	if getName(e) == 'BuildStarted':
		oestats_start(server, builder, e.data)
	elif getName(e) == 'BuildCompleted':
		oestats_stop(server, e.data, e.getFailures())
	elif getName(e) == 'TaskStarted':
		bb.data.setVar('OESTATS_STAMP', repr(time.time()), e.data)
	elif getName(e) == 'TaskSucceeded':
		oestats_task(server, e.data, e.task, 'Succeeded')
	elif getName(e) == 'TaskFailed':
		oestats_task(server, e.data, e.task, 'Failed')
}
