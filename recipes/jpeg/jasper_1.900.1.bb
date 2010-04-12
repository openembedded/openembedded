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

SRC_URI[md5sum] = "a342b2b4495b3e1394e161eb5d85d754"
SRC_URI[sha256sum] = "6b905a9c2aca2e275544212666eefc4eb44d95d0a57e4305457b407fe63f9494"
