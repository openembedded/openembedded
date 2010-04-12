PR         = "r2"
LICENSE    = "GPL"

DEPENDS = "gtk+-2.6.4-1.osso7 matchbox-wm dbus osso-esd"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://hildon-initscripts-source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-initscripts-0.8.14"

inherit autotools pkgconfig

SRC_URI[md5sum] = "1dbed6346a9db52b4089cbea8786b365"
SRC_URI[sha256sum] = "0dadf64980c5653336a0008b1fd8d77e54596710f5ae59b68115923731b2438f"
