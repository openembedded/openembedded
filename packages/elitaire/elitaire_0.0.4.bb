DESCRIPTION = "EFL-based solitaire"
DEPENDS = "evas-x11 ecore-x11 edje esmart-x11 ewl"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r0"

SRC_URI = "http://www.mowem.de/elitaire/elitaire-0.0.4.tar.bz2 \
           file://fix-ewl-and-gettext.patch;patch=1"

inherit autotools pkgconfig binconfig

