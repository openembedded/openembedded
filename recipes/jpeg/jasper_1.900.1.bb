DESCRIPTION = "Jpeg 2000 implementation"
LICENSE = "MIT"
do_unpack[depends] += "unzip-native:do_populate_staging"

SRC_URI = "http://www.ece.uvic.ca/~mdadams/jasper/software/jasper-${PV}.zip"

inherit autotools lib_package

EXTRA_OECONF = "--enable-shared"

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}
