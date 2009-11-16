SRC_DISTRIBUTE_DLONLY ?= "0"
SRC_DISTRIBUTECOMMAND[func] = "1"

addtask distribute_sources before do_build after do_fetch
python do_distribute_sources () {
	import re

	bb.build.exec_func("do_fetch", d)

	l = bb.data.createCopy(d)
	bb.data.update_data(l)

	licenses = (bb.data.getVar('LICENSE', d, 1) or "unknown").split()
	for license in licenses:
		for entry in license.split("|"):
			for url in ((bb.data.getVar('SRC_URI', d, 1) or '').split()):
				bb.fetch.init([url], d)
				s = bb.fetch.localpath(url, d)
				s = re.sub(';.*$', '', s)

				try:
					dlonly = int(d.getVar("SRC_DISTRIBUTE_DLONLY", 1))
				except ValueError:
					raise bb.build.FuncFailed("Invalid value for SRC_DISTRIBUTE_DLONLY: expected integer.")
				if dlonly:
					dldir = os.path.realpath(d.getVar("DL_DIR", 1) or "")
					if dldir and not \
					   os.path.realpath(s).startswith(dldir + os.path.sep):
							continue

				cmd = bb.data.getVar('SRC_DISTRIBUTECOMMAND', d, 1)
				if not cmd:
					raise bb.build.FuncFailed("Unable to distribute sources, SRC_DISTRIBUTECOMMAND not set")
				bb.debug(2, "srcdist: running %s" % cmd)
				bb.data.setVar('SRC', os.path.normpath(s), l)
				bb.data.setVar('LIC', entry, l)
				bb.build.exec_func('SRC_DISTRIBUTECOMMAND', l)
}

addtask distribute_sources_all after do_distribute_sources
do_distribute_sources_all[recrdeptask] = "do_distribute_sources"
do_distribute_sources_all[nostamp] = "1"

# compatability wrapper
addtask distsrcall after do_distribute_sources_all
do_distsrcall[nostamp] = "1"
