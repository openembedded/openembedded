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

