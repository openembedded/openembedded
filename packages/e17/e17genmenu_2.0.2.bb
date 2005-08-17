DESCRIPTION = "Convert Gnome or KDE menus to e17 menus"
SECTION = "e/utils"
DEPENDS = "e virtual/ecore virtual/evas eet engrave"
LICENSE = "MIT"
HOMEPAGE = "http://sourceforge.net/projects/e17genmenu"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"

export EET_CONFIG		= "${STAGING_BINDIR}/eet-config"
export EVAS_CONFIG		= "${STAGING_BINDIR}/evas-config"
export ECORE_CONFIG		= "${STAGING_BINDIR}/ecore-config"
export ENGRAVE_CONFIG		= "${STAGING_BINDIR}/engrave-config"
export ENLIGHTENMENT_CONFIG	= "${STAGING_BINDIR}/enlightenment-config"

SRC_URI = "${SOURCEFORGE_MIRROR}/e17genmenu/e17genmenu-2.0.2.tar.gz"

inherit autotools
