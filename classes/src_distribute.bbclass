SRC_DISTRIBUTE_DLONLY ?= "0"
SRC_DISTRIBUTECOMMAND[func] = "1"

addtask distribute_sources before do_build after do_fetch
python do_distribute_sources () {
	bb.build.exec_func("do_fetch", d)

	cmd = bb.data.getVar('SRC_DISTRIBUTECOMMAND', d, 1)
	if not cmd:
		raise bb.build.FuncFailed("Unable to distribute sources, SRC_DISTRIBUTECOMMAND not set")

	try:
		dlonly = int(d.getVar("SRC_DISTRIBUTE_DLONLY", 1))
	except ValueError:
		raise bb.build.FuncFailed("Invalid value for SRC_DISTRIBUTE_DLONLY: expected integer.")
	dldir = os.path.realpath(d.getVar("DL_DIR", 1) or "")

	licenses = (bb.data.getVar('LICENSE', d, 1) or "unknown").split()
	urldatadict = bb.fetch.init(d.getVar("SRC_URI", True).split(), d, True)
	for url, urldata in urldatadict.iteritems():
		if not urldata.setup:
			urldata.setup_localpath(d)

		local = urldata.localpath
		if dlonly and dldir and not \
		   os.path.realpath(local).startswith(dldir + os.path.sep):
			continue

		bb.data.setVar('SRC', os.path.abspath(local), d)
		for license in licenses:
			for entry in license.split("|"):
				bb.data.setVar('LIC', entry, d)
				bb.build.exec_func('SRC_DISTRIBUTECOMMAND', d)
}

addtask distribute_sources_all after do_distribute_sources
do_distribute_sources_all[recrdeptask] = "do_distribute_sources"
do_distribute_sources_all[nostamp] = "1"

# compatability wrapper
addtask distsrcall after do_distribute_sources_all
do_distsrcall[nostamp] = "1"
