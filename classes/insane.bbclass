#
# BB Class inspired by ebuild.sh
#
# As I will be copying code from from ebuild.sh this is
# Copyright Gentoo Foundation 1999-2006
# GPLv2
#
# This class will test files after installation for certain
# security issues and other kind of issues.
#
# Checks we do:
#  -Check the ownership and permissions
#  -Check the RUNTIME path for the $TMPDIR
#
# Checks that are planned:
#  -Check installed and stages .la files


#
# We need to have the scanelf utility as soon as
# possible.
#

# We play a special package function
inherit package
PACKAGE_DEPENDS += "pax-utils-native"
PACKAGEFUNCS += " do_package_qa "

python do_package_qa () {
}


