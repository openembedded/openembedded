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

python do_package_qa () {
}


