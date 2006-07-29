#
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

def package_qa_check_rpath(path):
    pass

def package_qa_check_devdbg(path, name):
    pass

def package_qa_check_perm(path):
    pass

def package_qa_check_staged(path):
    pass


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
        package_qa_check_rpath(path)
        package_qa_check_devdbg(path,package)
        package_qa_check_perm(path)
}


# The Staging Func, to check all staging
addtask qa_staging after do_populate_staging before do_build
python do_qa_staging() {
    bb.note("Staged!")
}
