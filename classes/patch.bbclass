# Copyright (C) 2006  OpenedHand LTD

# Point to an empty file so any user's custom settings don't break things
QUILTRCFILE ?= "${STAGING_BINDIR_NATIVE}/quiltrc"

PATCHDEPENDENCY = "${PATCHTOOL}-native:do_populate_sysroot"

PATCHTOOL[type] = "choice"
PATCHTOOL[choices] = "patch quilt git"
PATCHRESOLVE[type] = "choice"
PATCHRESOLVE[choices] = "noop user"

python patch_do_patch() {
	import oe.patch
	import oe.unpack

	src_uri = (bb.data.getVar('SRC_URI', d, 1) or '').split()
	if not src_uri:
		return

	patchsetmap = {
		"patch": oe.patch.PatchTree,
		"quilt": oe.patch.QuiltTree,
		"git": oe.patch.GitApplyTree,
	}

	cls = patchsetmap[bb.data.getVar('PATCHTOOL', d, 1) or 'quilt']

	resolvermap = {
		"noop": oe.patch.NOOPResolver,
		"user": oe.patch.UserResolver,
	}

	rcls = resolvermap[bb.data.getVar('PATCHRESOLVE', d, 1) or 'user']

	s = bb.data.getVar('S', d, 1)

	path = os.getenv('PATH')
	os.putenv('PATH', bb.data.getVar('PATH', d, 1))

	classes = {}

	src_uri = d.getVar("SRC_URI", True).split()
	srcurldata = bb.fetch.init(src_uri, d, True)
	workdir = bb.data.getVar('WORKDIR', d, 1)
	for url in src_uri:
		urldata = srcurldata[url]

		local = urldata.localpath
		if not local:
			raise bb.build.FuncFailed('Unable to locate local file for %s' % url)

		base, ext = os.path.splitext(os.path.basename(local))
		if ext in ('.gz', '.bz2', '.Z'):
			local = oe.path.join(workdir, base)

		if not oe.unpack.is_patch(local, urldata.parm):
			continue

		parm = urldata.parm

		if "striplevel" in parm:
			striplevel = parm["striplevel"]
		elif "pnum" in parm:
			bb.msg.warn(None, "Deprecated usage of 'pnum' url parameter in '%s', please use 'striplevel'" % url)
			striplevel = parm["pnum"]
		else:
			striplevel = '1'

		if "pname" in parm:
			pname = parm["pname"]
		else:
			pname = os.path.basename(local)

		if "mindate" in parm or "maxdate" in parm:
			pn = bb.data.getVar('PN', d, 1)
			srcdate = bb.data.getVar('SRCDATE_%s' % pn, d, 1)
			if not srcdate:
				srcdate = bb.data.getVar('SRCDATE', d, 1)

			if srcdate == "now":
				srcdate = bb.data.getVar('DATE', d, 1)

			if "maxdate" in parm and parm["maxdate"] < srcdate:
				bb.note("Patch '%s' is outdated" % pname)
				continue

			if "mindate" in parm and parm["mindate"] > srcdate:
				bb.note("Patch '%s' is predated" % pname)
				continue


		if "minrev" in parm:
			srcrev = bb.data.getVar('SRCREV', d, 1)
			if srcrev and srcrev < parm["minrev"]:
				bb.note("Patch '%s' applies to later revisions" % pname)
				continue

		if "maxrev" in parm:
			srcrev = bb.data.getVar('SRCREV', d, 1)
			if srcrev and srcrev > parm["maxrev"]:
				bb.note("Patch '%s' applies to earlier revisions" % pname)
				continue

		if "patchdir" in parm:
			patchdir = parm["patchdir"]
			if not os.path.isabs(patchdir):
				patchdir = os.path.join(s, patchdir)
		else:
			patchdir = s

		if not patchdir in classes:
			patchset = cls(patchdir, d)
			resolver = rcls(patchset)
			classes[patchdir] = (patchset, resolver)
			patchset.Clean()
		else:
			patchset, resolver = classes[patchdir]

		bb.note("Applying patch '%s' (%s)" % (pname, oe.path.format_display(local, d)))
		try:
			patchset.Import({"file":local, "remote":url, "strippath": striplevel}, True)
			resolver.Resolve()
		except Exception, exc:
			bb.fatal(str(exc))
}

def patch_deps(d):
    import oe.unpack

    src_uri = d.getVar("SRC_URI", True).split()
    srcurldata = bb.fetch.init(src_uri, d, True)
    for url in src_uri:
        urldata = srcurldata[url]
        local = urldata.localpath
        if local:
            base, ext = os.path.splitext(os.path.basename(local))
            if ext in ('.gz', '.bz2', '.Z', '.xz'):
                local = base
            if oe.unpack.is_patch(local, urldata.parm):
                return "${PATCHDEPENDENCY}"
    return ""

addtask patch after do_unpack
do_patch[dirs] = "${WORKDIR}"
do_patch[depends] = "${@patch_deps(d)}"

EXPORT_FUNCTIONS do_patch
