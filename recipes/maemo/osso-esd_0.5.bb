PR         = "r0"
LICENSE    = "GPL"
PROVIDES   = "esd"
RPROVIDES_${PN}  = "esd"

DEPENDS = "audiofile osso-dsp-headers"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/o/${PN}/${PN}_${PV}.orig.tar.gz \
           file://qa-silence.patch;patch=1"

# for qa-silence.patch:
export MME_INCDIR = "${STAGING_INCDIR}/mme"

S = "${WORKDIR}/esd"

inherit autotools pkgconfig


SRC_URI[md5sum] = "7f110e130db541b1aa9fc428b2620602"
SRC_URI[sha256sum] = "1a84b7d4939313e9b7ec0ce8f50934251fe1569e6144931dd323de8ee8dacccd"
