DESCRIPTION = "Linux::DVB - interface to (some parts of) the Linux DVB API"
SECTION = "libs"
LICENSE = "unknown"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/ML/MLEHMANN/Linux-DVB-${PV}.tar.gz"

S = "${WORKDIR}/Linux-DVB-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "67f0139f422893eddd8d9be4985b276f"
SRC_URI[sha256sum] = "abcb819e9fbca6d9bf740b2ab665cfaa82a8282746aefd997b2e093faa459303"
