DESCRIPTION = "This is a version of the netbook-launcher using Enlightenment Foundation Libraries (EFL) so it will run on systems without 3D acceleration required by Clutter."
LICENSE = "GPLv3"

DEPENDS = "libunique liblauncher libxau dbus-glib gtk+ libgnome libgnomeui edje edje-native libnotify libcanberra evas eina ecore elementary eet"
RDEPENDS_${PN} = "evas-loader-svg"

inherit gnome

SRC_URI = "http://launchpad.net/launch-lite-proj/0.3/${PV}/+download/netbook-launcher-efl-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "de795462d1a930008a3f6a52a09de6f5"
SRC_URI[archive.sha256sum] = "06e1eff757ae3fd8e5fc620f2a84581acc5710c691679516c0808d3c9c49d234"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

