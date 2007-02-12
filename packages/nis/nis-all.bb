# This meta package is a convenience to build all of the
# NIS packages.
#

DESCRIPTION="NIS services"
HOMEPAGE="http://www.linux-nis.org/nis/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"

INHIBIT_DEFAULT_DEPS = "1"

DEPENDS = "yp-tools ypbind ypserv pwdutils"
