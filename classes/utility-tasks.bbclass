addtask listtasks
do_listtasks[nostamp] = "1"
python do_listtasks() {
	import sys
	# emit variables and shell functions
	#bb.data.emit_env(sys.__stdout__, d)
	# emit the metadata which isnt valid shell
	for e in d.keys():
		if bb.data.getVarFlag(e, 'task', d):
			sys.__stdout__.write("%s\n" % e)
}

addtask clean
do_clean[dirs] = "${TOPDIR}"
do_clean[nostamp] = "1"
python do_clean() {
	"""clear the build and temp directories"""
	dir = bb.data.expand("${WORKDIR}", d)
	if dir == '//': raise bb.build.FuncFailed("wrong DATADIR")
	bb.note("removing " + base_path_out(dir, d))
	os.system('rm -rf ' + dir)

	dir = "%s.*" % bb.data.expand(bb.data.getVar('STAMP', d), d)
	bb.note("removing " + base_path_out(dir, d))
	os.system('rm -f '+ dir)
}

python do_cleanall() {
    pass
}
do_cleanall[recrdeptask] = "do_clean"
addtask cleanall after do_clean

addtask rebuild after do_${BB_DEFAULT_TASK}
do_rebuild[dirs] = "${TOPDIR}"
do_rebuild[nostamp] = "1"
python do_rebuild() {
	"""rebuild a package"""
}

addtask mrproper
do_mrproper[dirs] = "${TOPDIR}"
do_mrproper[nostamp] = "1"
python do_mrproper() {
	"""clear downloaded sources, build and temp directories"""
	dir = bb.data.expand("${DL_DIR}", d)
	if dir == '/': bb.build.FuncFailed("wrong DATADIR")
	bb.debug(2, "removing " + dir)
	os.system('rm -rf ' + dir)
	bb.build.exec_func('do_clean', d)
}

addtask distclean
do_distclean[dirs] = "${TOPDIR}"
do_distclean[nostamp] = "1"
python do_distclean() {
	"""clear downloaded sources, build and temp directories"""

	bb.build.exec_func('do_clean', d)

	src_uri = bb.data.getVar('SRC_URI', d, 1)
	if not src_uri:
		return

	for uri in src_uri.split():
		if bb.decodeurl(uri)[0] == "file":
			continue

		try:
			local = bb.data.expand(bb.fetch.localpath(uri, d), d)
		except bb.MalformedUrl, e:
			bb.debug(1, 'Unable to generate local path for malformed uri: %s' % e)
		else:
			bb.note("removing %s" % base_path_out(local, d))
			try:
				if os.path.exists(local + ".md5"):
					os.remove(local + ".md5")
				if os.path.exists(local):
					os.remove(local)
			except OSError, e:
				bb.note("Error in removal: %s" % e)
}

addtask checkuri
do_checkuri[nostamp] = "1"
python do_checkuri() {
	import sys

	localdata = bb.data.createCopy(d)
	bb.data.update_data(localdata)

	src_uri = bb.data.getVar('SRC_URI', localdata, 1)

	try:
		bb.fetch.init(src_uri.split(),d)
	except bb.fetch.NoMethodError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("No method: %s" % value)

	try:
		bb.fetch.checkstatus(localdata)
	except bb.fetch.MissingParameterError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Missing parameters: %s" % value)
	except bb.fetch.FetchError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Fetch failed: %s" % value)
	except bb.fetch.MD5SumError:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("MD5  failed: %s" % value)
	except:
		(type, value, traceback) = sys.exc_info()
		raise bb.build.FuncFailed("Unknown fetch Error: %s" % value)
}

addtask checkuriall after do_checkuri
do_checkuriall[recrdeptask] = "do_checkuri"
do_checkuriall[nostamp] = "1"
do_checkuriall() {
	:
}

addtask fetchall after do_fetch
do_fetchall[recrdeptask] = "do_fetch"
do_fetchall() {
	:
}

addtask buildall after do_build
do_buildall[recrdeptask] = "do_build"
do_buildall() {
	:
}
