# Integration with the oestats build statistics server, see:
#
# http://opensource.bolloretelecom.eu/projects/oestats
#
# To make use of this class, add to your local.conf:
#
# INHERIT += "oestats-client"
# OESTATS_SERVER = "some.server.org:8000"
# OESTATS_BUILDER = "some title"

def oestats_setid(d, val):
	import bb
	f = file(bb.data.getVar('TMPDIR', d, True) + '/oestats.id', 'w')
	f.write(val)

def oestats_getid(d):
	import bb
	f = file(bb.data.getVar('TMPDIR', d, True) + '/oestats.id', 'r')
	return f.read()
	
def oestats_revision(dir):
	import re
	try:
		f = file("%s/_MTN/revision" % dir)
		m = re.search(r"old_revision \[(.*)\]", f.read())
		return m.group(1)
	except:
		return

def oestats_send(server, action, vars = {}):
	import httplib, urllib

	params = urllib.urlencode(vars)
	headers = {"Content-type": "application/x-www-form-urlencoded",
		"Accept": "text/plain"}
	conn = httplib.HTTPConnection(server)
	conn.request("POST", action, params, headers)
	response = conn.getresponse()
	conn.close()
	return response

def oestats_start(server, builder, d):
	import bb
	import os.path

	# collect information about revisions
	path_bb = bb.data.getVar('BBPATH', d, True)
	for p in (path_bb or "").split(':'):
		revision = oestats_revision(p)
		if revision:
			break

	# send report
	response = oestats_send(server, "/builds/start/", {
		'builder': builder,
		'revision': revision,
		'machine': bb.data.getVar('MACHINE', d, True),
		'distro': bb.data.getVar('DISTRO', d, True),
	})
	id = response.read()

	# save the build id
	oestats_setid(d, id)

def oestats_stop(server, d, status):
	import bb

	# retrieve build id
	id = oestats_getid(d)

	# send report
	response = oestats_send(server, "/builds/stop/%s/" % id, {
		'status': status,
	})

def oestats_task(server, d, task, status):
	import bb
	import time

	# retrieve build id
	id = oestats_getid(d)
	try:
		elapsed = time.time() - float(bb.data.getVar('OESTATS_STAMP', d, True))
	except:
		elapsed = 0

	# send report
	response = oestats_send(server, "/builds/task/%s/" % id, {
		'package': bb.data.getVar('PN', d, True),
		'version': bb.data.getVar('PV', d, True),
		'revision': bb.data.getVar('PR', d, True),
		'task': task,
		'status': status,
		'time': elapsed,
	})

addhandler oestats_eventhandler
python oestats_eventhandler () {
	from bb.event import getName
	import bb
	import time

	if e.data is None or getName(e) == "MsgNote":
		return NotHandled

	server = bb.data.getVar('OESTATS_SERVER', e.data, True)
	builder = bb.data.getVar('OESTATS_BUILDER', e.data, True)
	if not server or not builder:
		return NotHandled

	if getName(e) == 'BuildStarted':
		oestats_start(server, builder, e.data)
	elif getName(e) == 'BuildCompleted':
		oestats_stop(server, e.data, 'Completed')
	elif getName(e) == 'TaskStarted':
		bb.data.setVar('OESTATS_STAMP', repr(time.time()), e.data)
	elif getName(e) == 'TaskSucceeded':
		oestats_task(server, e.data, e.task, 'Succeeded')
	elif getName(e) == 'TaskFailed':
		oestats_task(server, e.data, e.task, 'Failed')

	return NotHandled
}
