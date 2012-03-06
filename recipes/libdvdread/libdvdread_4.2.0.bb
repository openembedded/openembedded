DESCRIPTION = "DVD access multimeda library"
SECTION = "libs/multimedia"
LICENSE = "GPLv2+"
HOMEPAGE = "http://packages.debian.org/libdvdread"
PR = "r1"

SRC_URI = "${DEBIAN_MIRROR}/main/libd/libdvdread/libdvdread_${PV}.orig.tar.gz;name=archive" 

S = "${WORKDIR}/libdvdread-${PV}"

inherit autotools lib_package binconfig pkgconfig

addtask unpackpost after do_unpack before do_patch

SRC_URI[archive.md5sum] = "815de47b35eae77579952db58e06914a"
SRC_URI[archive.sha256sum] = "e03b007407d5869c7a58d0fe5205e87a655171b4750ff163f3cf459741430bf8"

