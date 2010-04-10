DESCRIPTION = "Madplay is a command-line MPEG audio decoder and player"
SECTION = "console/multimedia"
DEPENDS = "libmad"
LICENSE = "GPL"
AUTHOR = "Robert Leslie <rob@mars.org>"
HOMEPAGE = "http://www.mars.org/home/rob/proj/mpeg/"

SRC_URI = "ftp://ftp.mars.org/pub/mpeg/${PN}-${PV}.tar.gz"

inherit autotools
ARM_INSTRUCTION_SET = "arm"

FILES_${PN} = "${bindir}/madplay"

SRC_URI[md5sum] = "6814b47ceaa99880c754c5195aa1aac1"
SRC_URI[sha256sum] = "5a79c7516ff7560dffc6a14399a389432bc619c905b13d3b73da22fa65acede0"
