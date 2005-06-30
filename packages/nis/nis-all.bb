# This meta package is a convenience to build all of the
# NIS packages.
#
PR = "r0"
DESCRIPTION="NIS services"
HOMEPAGE="http://www.linux-nis.org/nis/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "console/networking"
PRIORITY = "optional"
LICENSE = "GPL-2"

INHIBIT_DEFAULT_DEPS = "1"

DEPENDS = "yp-tools ypbind ypserv pwdutils"
