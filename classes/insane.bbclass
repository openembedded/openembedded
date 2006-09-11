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
#  -Check if packages contains .dbg or .so files where they should be in -dev or -dbg
#


#
# We need to have the scanelf utility as soon as
# possible and this is contained within the pax-utils-native
#

# We play a special package function
inherit package
PACKAGE_DEPENDS += "pax-utils-native"
PACKAGEFUNCS += " do_package_qa "

def package_qa_check_rpath(file,name):
    """
    Check for dangerous RPATHs
    """
    pass

def package_qa_check_devdbg(path, name):
    """
    Check for debug remains inside the binary or
    non dev packages containing
    """
    if not "-dev" in name:
        if path[-3:] == ".so":
            bb.error("QA Issue: non dev package contains .so")

    if not "-dbg" in name:
        if path[-4:] == ".dbg":
            bb.error("QA Issue: non debug package contains .dbg file")

def package_qa_check_perm(path,name):
    """
    Check the permission of files
    """
    pass

def package_qa_check_arch(path,name):
    """
    Check if archs are compatible
    """
    pass

def package_qa_check_pcla(path,name):
    """
    .pc and .la files should not point
    """

def package_qa_check_staged(path):
    """
    Check staged la and pc files for sanity
      -e.g. installed being false
    """
    pass

# Walk over all files in a directory and call func
def package_qa_walk(path, funcs, package):
    import os
    for root, dirs, files in os.walk(path):
        for file in files:
            path = os.path.join(root,file)
            for func in funcs:
                func(path, package)


# The PACKAGE FUNC to scan each package
python do_package_qa () {
    bb.note("DO PACKAGE QA")
    workdir  = bb.data.getVar('WORKDIR', d, True)
    packages = bb.data.getVar('PACKAGES',d, True)

    # no packages should be scanned
    if not packages:
        return

    for package in packages.split():
        bb.note("Package: %s" % package)
        path = "%s/install/%s" % (workdir, package)
        package_qa_walk(path, [package_qa_check_rpath, package_qa_check_devdbg, package_qa_check_perm, package_qa_check_arch], package)
}


# The Staging Func, to check all staging
addtask qa_staging after do_populate_staging before do_build
python do_qa_staging() {
    bb.note("Staged!")

    package_qa_check_staged(bb.data.getVar('STAGING_DIR',d,True))
}
