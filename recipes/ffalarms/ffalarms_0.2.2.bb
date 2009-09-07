DESCRIPTION = "Finger friendly alarms"
HOMEPAGE = "http://ffalarms.projects.openmoko.org/"
LICENSE = "GPLv3"
AUTHOR = "Lukasz Pankowski <lukpank@o2.pl>"
MAINTAINER = "Lukasz Pankowski <lukpank@o2.pl>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "edje-native python-native"

# Pure Python plus Edje interface
PACKAGE_ARCH = "all"

SRC_URI = "http://projects.openmoko.org/frs/download.php/832/ffalarms-0.2.2.tar.gz"

inherit distutils

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications/ffalarms.desktop ${datadir}/pixmaps"

RDEPENDS += "python-re python-datetime python-edje python-ecore \
             atd-over-fso alsa-utils-amixer alsa-utils-alsactl \
             ttf-dejavu-sans"

RSUGGESTS += "mplayer alsa-utils-aplay openmoko-alsa-scenarios"
