require gst-plugins.inc
DEPENDS += "gst-plugins-base libsidplay"
PROVIDES += "gst-plugin-sid"

PR = "${INC_PR}.1"

SRC_URI = "\
  http://gstreamer.freedesktop.org/src/gst-plugins-ugly/gst-plugins-ugly-${PV}.tar.bz2 \
  file://gstsid_autofoo_HACK.patch;patch=1 \
"
S = "${WORKDIR}/gst-plugins-ugly-${PV}"

python() {
    # Don't build, if we are building an ENTERPRISE distro
    enterprise = bb.data.getVar("ENTERPRISE_DISTRO", d, 1)
    if enterprise != "1":
            raise bb.parse.SkipPackage("gst-plugins-ugly-sid will only build if ENTERPRISE_DISTRO == 1")
}

SRC_URI[md5sum] = "cff4f55138d12152cf580a3ee71c2519"
SRC_URI[sha256sum] = "556ba24072bdb32ee568adc682d69add1241d77936bc9563e50cdb953097be35"
