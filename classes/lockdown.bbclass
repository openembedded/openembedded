addtask show_versions before do_build
do_show_versions[nostamp] = "1"
python do_show_versions() {
	import sys

	localdata = bb.data.createCopy(d)
	bb.data.update_data(localdata)

	src_uri = bb.data.getVar('SRC_URI', localdata, 1)
	if not src_uri:
		return 1

	try:
		bb.fetch.init(src_uri.split(),d)
	except bb.fetch.NoMethodError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("No method: %s" % value)


	src_uri = bb.data.getVar("SRC_URI", d, False)
	pn = bb.data.getVar("PN", d, True)
	src_revs = open("%s/src_revs.inc" % bb.data.getVar("TMPDIR", d, 1), "a")
	src_dates = open("%s/src_dates.inc" % bb.data.getVar("TMPDIR", d, 1), "a")
	pref_versions = open("%s/preferred_versions.inc" % bb.data.getVar("TMPDIR", d, 1), "a")
	if "SRCREV" in bb.data.getVar("PV", d, False):
		print >> src_revs, 'SRCREV_pn-%(pn)s ?= "%(rev)s"' % { 'pn' : pn, 'rev' : bb.data.getVar("SRCREV", d, True) }
	elif "cvs://" in src_uri or "svn://" in src_uri or "git://" in src_uri:
		print >> src_dates, 'SRCDATE_pn-%(pn)s ?= "%(date)s"' % { 'pn' : pn, 'date' : bb.data.getVar("SRCDATE", d, True) }

	print >> pref_versions, 'PREFERRED_VERSION_%(pn)s = "%(version)s"' % { "pn" : pn, 'version' : bb.data.getVar("PV", d, True) }
	src_revs.close()
	src_dates.close()
	pref_versions.close()
}

addtask lockdown
do_lockdown[nostamp] = "1"
do_lockdown[recrdeptask] = "do_show_versions"
python do_lockdown() {
}

