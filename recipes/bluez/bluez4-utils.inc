DESCRIPTION = "Linux Bluetooth Stack Userland V4"
SECTION = "net"
PRIORITY = "optional"
# NOTE: sndfile is only a dependency if you want the sbctester app.
DEPENDS = "bison-native alsa-lib libusb-compat dbus-glib bluez-libs"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
INC_PR = "r2"

FILESPATHPKG .= ":bluez4-${PV}:bluez4"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/bluez-${PV}.tar.gz \
          file://fix-dfutool-usb-declaration-mismatch.patch;patch=1 \
  file://sbc-thumb.patch;patch=1 \
  file://bluetooth.conf \
  file://separate-libs.patch;patch=1 \
"

S = "${WORKDIR}/bluez-${PV}"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

EXTRA_AUTORECONF = "-I ${S}"
EXTRA_OECONF = " \
  --enable-alsa \
  --enable-usb \
  --enable-netlink \
  --enable-tools \
  --enable-bccmd \
  --enable-hid2hci \
  --enable-dfutool \
  --enable-hidd \
  --enable-pandd \
  --enable-dund \
  --disable-cups \
  --enable-test \
  --enable-manpages \
  --enable-configfiles \
  --enable-initscripts \
  --disable-pcmciarules \
  --disable-gstreamer \
  --with-bluez=${STAGING_LIBDIR} \
"

do_configure_prepend() {
        sed 's/ include / /;s/ lib / /' <Makefile.am >Makefile.am.new
        mv Makefile.am.new Makefile.am
}

do_install_append() {
        install -m 0644 ${S}/audio/audio.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/network/network.conf ${D}/${sysconfdir}/bluetooth/
        install -m 0644 ${S}/input/input.conf ${D}/${sysconfdir}/bluetooth/
        # at_console doesn't really work with the current state of OE, so punch some more holes so people can actually use BT
        install -m 0644 ${WORKDIR}/bluetooth.conf ${D}/${sysconfdir}/dbus-1/system.d/
        ${B}/${HOST_SYS}-libtool --mode=install install -D -m 0755 test/agent ${D}${bindir}/bluetooth-agent
}

PACKAGES =+ "gst-plugin-bluez libasound-module-bluez"

FILES_gst-plugin-bluez = "${libdir}/gstreamer-0.10/lib*.so"
FILES_libasound-module-bluez = "${libdir}/alsa-lib/lib*.so"
FILES_${PN} += "${libdir}/bluetooth/plugins/*.so"
FILES_${PN}-dev = ""
