HOMEPAGE = "http://www.ofono.org"
SUMMARY  = "open source telephony"
DESCRIPTION = "oFono is a stack for mobile telephony devices on Linux. oFono supports speaking to telephony devices through specific drivers, or with generic AT commands."
LICENSE  = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=eb723b61539feef013de476e68b5c50a \
                    file://src/ofono.h;beginline=1;endline=20;md5=85d349dd8ec342c8f40d90e520f22779"
INC_PR = "r3"

inherit autotools pkgconfig update-rc.d

DEPENDS  = "dbus glib-2.0 udev"

EXTRA_OECONF += " --disable-bluetooth --enable-test"

INITSCRIPT_NAME = "ofono"
INITSCRIPT_PARAMS = "defaults 22"

do_install_append() {
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/ofono ${D}${sysconfdir}/init.d/ofono
}

PACKAGES =+ "${PN}-test-utils"

RDEPENDS_${PN}-test-utils += "python-dbus"

FILES_${PN} += "/lib/udev/rules.d"
FILES_${PN}-test-utils += "${libdir}/ofono/test"

