python populate_staging_prehook () {
       return
}

python populate_staging_posthook () {
       return
}

packagedstaging_fastpath () {
       :
}

def package_stagefile(file, d):
    if bb.data.getVar('PSTAGING_ACTIVE', d, True) == "1":
        destfile = file.replace(bb.data.getVar("TMPDIR", d, 1), bb.data.getVar("PSTAGE_TMPDIR_STAGE", d, 1))
        bb.mkdirhier(os.path.dirname(destfile))
        #print "%s to %s" % (file, destfile)
        bb.copyfile(file, destfile)

package_stagefile_shell() {
	if [ "$PSTAGING_ACTIVE" = "1" ]; then
		srcfile=$1
		destfile=`echo $srcfile | sed s#${TMPDIR}#${PSTAGE_TMPDIR_STAGE}#`
		destdir=`dirname $destfile`
		mkdir -p $destdir
		cp -dp $srcfile $destfile
	fi
}

sysroot_stage_dir() {
	src="$1"
	dest="$2"
	# This will remove empty directories so we can ignore them
	rmdir "$src" 2> /dev/null || true
	if [ -d "$src" ]; then
		mkdir -p "$dest"
		cp -fpPR "$src"/* "$dest"
	fi
}

sysroot_stage_libdir() {
	src="$1"
	dest="$2"

	olddir=`pwd`
	cd $src
	las=$(find . -name \*.la -type f)
	cd $olddir
	echo "Found la files: $las"		 
	for i in $las
	do
		sed -e 's/^installed=yes$/installed=no/' \
		    -e '/^dependency_libs=/s,${WORKDIR}[[:alnum:]/\._+-]*/\([[:alnum:]\._+-]*\),${STAGING_LIBDIR}/\1,g' \
		    -e "/^dependency_libs=/s,\([[:space:]']\)${libdir},\1${STAGING_LIBDIR},g" \
		    -i $src/$i
	done
	sysroot_stage_dir $src $dest
}

sysroot_stage_dirs() {
	from="$1"
	to="$2"

	sysroot_stage_dir $from${includedir} $to${STAGING_INCDIR}
	if [ "${BUILD_SYS}" = "${HOST_SYS}" ]; then
		sysroot_stage_dir $from${bindir} $to${STAGING_DIR_HOST}${bindir}
		sysroot_stage_dir $from${sbindir} $to${STAGING_DIR_HOST}${sbindir}
		sysroot_stage_dir $from${base_bindir} $to${STAGING_DIR_HOST}${base_bindir}
		sysroot_stage_dir $from${base_sbindir} $to${STAGING_DIR_HOST}${base_sbindir}
		sysroot_stage_dir $from${libexecdir} $to${STAGING_DIR_HOST}${libexecdir}
		if [ "${prefix}/lib" != "${libdir}" ]; then
			# python puts its files in here, make sure they are staged as well
			autotools_stage_dir $from/${prefix}/lib $to${STAGING_DIR_HOST}${prefix}/lib
		fi
	fi
	if [ -d $from${libdir} ]
	then
		sysroot_stage_libdir $from/${libdir} $to${STAGING_LIBDIR}
	fi
	if [ -d $from${base_libdir} ]
	then
		sysroot_stage_libdir $from${base_libdir} $to${STAGING_DIR_HOST}${base_libdir}
	fi
	sysroot_stage_dir $from${datadir} $to${STAGING_DATADIR}
	sysroot_stage_dir $from${sysconfdir} $to${STAGING_ETCDIR}
}

sysroot_stage_all() {
	sysroot_stage_dirs ${D} ${SYSROOT_DESTDIR}
}

def is_legacy_staging(d):
    stagefunc = bb.data.getVar('do_stage', d, True)
    legacy = True
    if stagefunc is None:
        legacy = False
    elif stagefunc.strip() == "autotools_stage_all":
        legacy = False
    elif stagefunc.strip() == "do_stage_native" and bb.data.getVar('AUTOTOOLS_NATIVE_STAGE_INSTALL', d, 1) == "1":
        legacy = False
    elif bb.data.getVar('NATIVE_INSTALL_WORKS', d, 1) == "1":
        legacy = False
    if bb.data.getVar('PSTAGE_BROKEN_DESTDIR', d, 1) == "1":
        legacy = True
    if bb.data.getVar('FORCE_LEGACY_STAGING', d, 1) == "1":
        legacy = True
    return legacy

do_populate_staging[dirs] = "${STAGING_DIR_TARGET}/${bindir} ${STAGING_DIR_TARGET}/${libdir} \
			     ${STAGING_DIR_TARGET}/${includedir} \
			     ${STAGING_BINDIR_NATIVE} ${STAGING_LIBDIR_NATIVE} \
			     ${STAGING_INCDIR_NATIVE} \
			     ${STAGING_DATADIR} \
			     ${S} ${B}"

# Could be compile but populate_staging and do_install shouldn't run at the same time
addtask populate_staging after do_install before do_build

SYSROOT_PREPROCESS_FUNCS ?= ""
SYSROOT_DESTDIR = "${WORKDIR}/sysroot-destdir/"
SYSROOT_LOCK = "${STAGING_DIR}/staging.lock"

python do_populate_staging () {
    #
    # if do_stage exists, we're legacy. In that case run the do_stage,
    # modify the SYSROOT_DESTDIR variable and then run the staging preprocess
    # functions against staging directly.
    #
    # Otherwise setup a destdir, copy the results from do_install
    # and run the staging preprocess against that
    #
    pstageactive = (bb.data.getVar("PSTAGING_ACTIVE", d, True) == "1")
    lockfile = bb.data.getVar("SYSROOT_LOCK", d, True)
    stagefunc = bb.data.getVar('do_stage', d, True)
    legacy = is_legacy_staging(d)
    if legacy:
        bb.data.setVar("SYSROOT_DESTDIR", "", d)
        bb.note("Legacy staging mode for %s" % bb.data.getVar("FILE", d, True))

        try:
            file = open("%s/legacy-staging.log" % bb.data.getVar("TMPDIR", d, 1), "a")
	    file.write("%s\n" % bb.data.getVar("FILE", d, True))
	    file.close()
        except:
            pass

        if bb.data.getVarFlags('do_stage', d) is None:
            bb.fatal("This recipe (%s) has a do_stage_prepend or do_stage_append and do_stage now doesn't exist. Please rename this to do_stage()" % bb.data.getVar("FILE", d, True))
        lock = bb.utils.lockfile(lockfile)
        bb.build.exec_func('populate_staging_prehook', d)
        bb.build.exec_func('do_stage', d)
        for f in (bb.data.getVar('SYSROOT_PREPROCESS_FUNCS', d, True) or '').split():
            bb.build.exec_func(f, d)
        bb.build.exec_func('populate_staging_posthook', d)
        bb.utils.unlockfile(lock)
    else:
        dest = bb.data.getVar('D', d, True)
        sysrootdest = bb.data.expand('${SYSROOT_DESTDIR}${STAGING_DIR_TARGET}', d)
        bb.mkdirhier(sysrootdest)

        bb.build.exec_func("sysroot_stage_all", d)
        #os.system('cp -pPR %s/* %s/' % (dest, sysrootdest))
        for f in (bb.data.getVar('SYSROOT_PREPROCESS_FUNCS', d, True) or '').split():
            bb.build.exec_func(f, d)
        bb.build.exec_func("packagedstaging_fastpath", d)

        lock = bb.utils.lockfile(lockfile)
        os.system(bb.data.expand('cp -pPR ${SYSROOT_DESTDIR}${TMPDIR}/* ${TMPDIR}/', d))
        bb.utils.unlockfile(lock)
}

python () {
    if is_legacy_staging(d):
        bb.debug(1, "Legacy staging mode for %s" % bb.data.getVar("FILE", d, True))
        if bb.data.getVarFlags('do_stage', d) is None:
            bb.error("This recipe (%s) has a do_stage_prepend or do_stage_append and do_stage now doesn't exist. Please rename this to do_stage()" % bb.data.getVar("FILE", d, True))
}
