DESCRIPTION = "Linux Bluetooth Stack Userland V4"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "gst-plugins-base alsa-lib virtual/libusb0 dbus-glib"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"

# For angstrom we want this to replace at least bluez-libs
PROVIDES_append_angstrom = " bluez-utils bluez-libs"

# temporary solution for KaeilOS just to replace at least bluez-libs
PROVIDES_append_angstrom = " bluez-utils bluez-libs"

PR = "r2"

SRC_URI = "\
  http://www.kernel.org/pub/linux/bluetooth/bluez-${PV}.tar.gz \
  file://fix-dfutool-usb-declaration-mismatch.patch;patch=1 \
  file://sbc-thumb.patch;patch=1 \
  file://bluetooth.conf \
"
S = "${WORKDIR}/bluez-${PV}"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

EXTRA_OECONF = "\
  --enable-gstreamer \
  --enable-alsa \
  --enable-usb \
  --enable-netlink \
  --enable-tools \
  --enable-bccmd \
  --enable-hid2hci \
  --enable-dfutool \
  --enable-hidd \
  --enable-pand \
  --enable-dund \
  --disable-cups \
  --enable-test \
  --enable-manpages \
  --enable-configfiles \
  --enable-initscripts \
  --disable-pcmciarules \
"

do_install_append() {
        install -m 0644 ${S}/audio/audio.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/network/network.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/input/input.conf ${D}/${sysconfdir}/bluetooth/
        # at_console doesn't really work with the current state of OE, so punch some more holes so people can actually use BT
        install -m 0644 ${WORKDIR}/bluetooth.conf ${D}/${sysconfdir}/dbus-1/system.d/
}

PACKAGES =+ "gst-plugin-bluez libasound-module-bluez"

FILES_gst-plugin-bluez = "${libdir}/gstreamer-0.10/lib*.so"
FILES_libasound-module-bluez = "${libdir}/alsa-lib/lib*.so"
FILES_${PN} += "${libdir}/bluetooth/plugins/*.so"
FILES_${PN}-dev += "\
  ${libdir}/bluetooth/plugins/*.la \
  ${libdir}/alsa-lib/*.la \
  ${libdir}/gstreamer-0.10/*.la \
"

FILES_${PN}-dbg += "\
  ${libdir}/bluetooth/plugins/.debug \
  ${libdir}/*/.debug \
"

SRC_URI[md5sum] = "5919d6383cd9446f8b90fdca748dc961"
SRC_URI[sha256sum] = "e5e592de95f50a1569d3e4a95c8b955a2535e265e24869e3ce30e19b0949b465"
