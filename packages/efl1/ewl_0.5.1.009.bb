DESCRIPTION = "The Enlightened Widget Library, \
a simple-to-use general purpose widget library \
based on the enlightenment foundation libraries."
DEPENDS = "evas ecore edje emotion efreet"
RSUGGESTS_${PN} += "ewl-themes"
LICENSE = "MIT"
PR = "r0"

inherit efl1

SRC_URI = "http://download.enlightenment.org/snapshots/2007-06-17/ewl-${PV}.tar.gz"
