DESCRIPTION = "decoding library for DTS Coherent Acoustics streams"
SECTION = "libs/multimedia"
LICENSE = "GPLv2+"

SRC_URI = "git://git.debian.org/pkg-multimedia/${PN}.git;protocol=git"

SRCREV = "6031938c28a2e66eed6f2b9bac1467364e25068d"
S = "${WORKDIR}/git"

inherit autotools lib_package pkgconfig

do_unpackpost() {
        QUILT_PATCHES=debian/patches quilt push -a
        # single precision is enough and speeds up libdca by about 10-15%
        sed -i -e 's/double/sample_t/g' ${S}/libdca/*.{ch}
}

addtask unpackpost after do_unpack before do_patch
