# BB Class inspired by ebuild.sh
#
# This class will test files after installation for certain
# security issues and other kind of issues.
#
# Checks we do:
#  -Check the ownership and permissions
#  -Check the RUNTIME path for the $TMPDIR
#  -Check if .la files wrongly point to workdir
#  -Check if .pc files wrongly point to workdir
#  -Check if packages contains .debug directories  or .so files where they should be in -dev or -dbg
#  -Check if config.log contains traces to broken autoconf tests
#


#
# We need to have the scanelf utility as soon as
# possible and this is contained within the pax-utils-native
#


# We play a special package function
inherit package
PACKAGE_DEPENDS += "pax-utils-native"
PACKAGEFUNCS += " do_package_qa "

def package_qa_clean_path(path,d):
    import bb
    return path.replace(bb.data.getVar('TMPDIR',d,True),"")

def package_qa_write_error(error_class, name, path, d):
    import bb, os
    if not bb.data.getVar('QA_LOG', d):
        return

    ERROR_NAMES =[
        "dev/dbg contains .so",
        "package contains RPATH",
        "package depends on debug package",
    ]


    log_path = os.path.join( bb.data.getVar('T', d, True), "log.qa_package" )
    f = file( log_path, "a+")
    print >> f, "%s, %s, %s" % (ERROR_NAMES[error_class], name, package_qa_clean_path(path,d))
    f.close()


def package_qa_check_rpath(file,name,d):
    """
    Check for dangerous RPATHs
    """
    import bb, os
    scanelf = os.path.join(bb.data.getVar('STAGING_BINDIR_NATIVE',d,True),'scanelf')
    bad_dir = bb.data.getVar('TMPDIR', d, True) + "/work"
    if not os.path.exists(scanelf):
        bb.fatal("Can not check RPATH scanelf not found")
    if not bad_dir in bb.data.getVar('WORKDIR', d, True):
        bb.fatal("This class assumed that WORKDIR is ${TMPDIR}/work... Not doing any check")

    output = os.popen("%s -Byr %s" % (scanelf,file))
    txt    = output.readline().rsplit()
    if bad_dir in txt:
        package_qa_write_error( 1, name, file, d)
        bb.error("QA Issue package %s contains bad RPATH %s in file %s" % (name, txt, file))
        return False

    return True

def package_qa_check_devdbg(path, name,d):
    """
    Check for debug remains inside the binary or
    non dev packages containing
    """

    import bb
    sane = True

    if not "-dev" in name:
        if path[-3:] == ".so":
            package_qa_write_error( 0, name, path, d )
            bb.error("QA Issue: non dev package contains .so: %s path '%s'" % (name, package_qa_clean_path(path,d)))
            sane = False

    if not "-dbg" in name:
        if '.debug' in path:
            package_qa_write_error( 0, name, path, d )
            bb.error("QA Issue: non debug package contains .debug directory: %s path %s" % (name, package_qa_clean_path(path,d)))
            sane = False

    return sane

def package_qa_check_perm(path,name,d):
    """
    Check the permission of files
    """
    sane = True
    return sane

def package_qa_check_arch(path,name,d):
    """
    Check if archs are compatible
    """
    sane = True
    return sane

def package_qa_check_pcla(path,name,d):
    """
    .pc and .la files should not point to the WORKDIR
    """
    sane = True
    return sane

def package_qa_check_staged(path,d):
    """
    Check staged la and pc files for sanity
      -e.g. installed being false
    """
    sane = True
    return sane

# Walk over all files in a directory and call func
def package_qa_walk(path, funcs, package,d):
    import os
    sane = True

    for root, dirs, files in os.walk(path):
        for file in files:
            path = os.path.join(root,file)
            for func in funcs:
                if not func(path, package,d):
                    sane = False

    return sane


def package_qa_check_rdepends(pkg, workdir, d):
    import bb
    sane = True
    if not "-dbg" in pkg and not "task-" in pkg and not "-image" in pkg:
        # Copied from package_ipk.bbclass
        # boiler plate to update the data
        localdata = bb.data.createCopy(d)
        root = "%s/install/%s" % (workdir, pkg)

        bb.data.setVar('ROOT', '', localdata) 
        bb.data.setVar('ROOT_%s' % pkg, root, localdata)
        pkgname = bb.data.getVar('PKG_%s' % pkg, localdata, 1)
        if not pkgname:
            pkgname = pkg
        bb.data.setVar('PKG', pkgname, localdata)

        overrides = bb.data.getVar('OVERRIDES', localdata)
        if not overrides:
            raise bb.build.FuncFailed('OVERRIDES not defined')
        overrides = bb.data.expand(overrides, localdata)
        bb.data.setVar('OVERRIDES', overrides + ':' + pkg, localdata)

        bb.data.update_data(localdata)

        # Now check the RDEPENDS
        rdepends = explode_deps(bb.data.getVar('RDEPENDS', localdata, True) or "")


        # Now do the sanity check!!!
        for rdepend in rdepends:
            if "-dbg" in rdepend:
                package_qa_write_error( 2, name, rdepend, d )
                bb.error("QA issue, koen give us a better msg!!!")
                sane = False

    return sane

# The PACKAGE FUNC to scan each package
python do_package_qa () {
    bb.note("DO PACKAGE QA")
    workdir = bb.data.getVar('WORKDIR', d, True)
    packages = bb.data.getVar('PACKAGES',d, True)

    # no packages should be scanned
    if not packages:
        return

    walk_sane = True
    rdepends_sane = True
    for package in packages.split():
        bb.note("Checking Package: %s" % package)
        path = "%s/install/%s" % (workdir, package)
        if not package_qa_walk(path, [package_qa_check_rpath, package_qa_check_devdbg, package_qa_check_perm, package_qa_check_arch], package, d):
            walk_sane  = False
        if not package_qa_check_rdepends(package, workdir, d):
            rdepends_sane = False

    if not walk_sane or not rdepends_sane:
        bb.fatal("QA ran found fatal errors. Please consider fixing them")
    bb.note("DONE with PACKAGE QA")
}


# The Staging Func, to check all staging
addtask qa_staging after do_populate_staging before do_build
python do_qa_staging() {
    bb.note("Staged!")

    package_qa_check_staged(bb.data.getVar('STAGING_DIR',d,True), d)
}

# Check broken config.log files
addtask qa_configure after do_configure before do_compile
python do_qa_configure() {
    bb.note("Checking sanity of the config.log file")
    import os
    for root, dirs, files in os.walk(bb.data.getVar('WORKDIR', d, True)):
        if "config.log" in files:
            if os.system("grep 'CROSS COMPILE Badness:' %s > /dev/null" % (os.path.join(root,"config.log"))) == 0:
                bb.fatal("This autoconf log indicates errors, it looked at host includes. Rerun configure task after fixing this. Path was '%s'", root)
}
