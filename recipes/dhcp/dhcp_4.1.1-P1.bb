require dhcp4.inc

PR = "${INC_PR}.1"

SRC_URI += "file://fixincludes.patch \
            file://dhcp-3.0.3-dhclient-dbus.patch;striplevel=0 \
            file://fix-client-path.patch"

SRC_URI[md5sum] = "ee390a35687dd75dbfc32c856c0938d1"
SRC_URI[sha256sum] = "2f640350cbb1966ec3090198c3f128d649a3655f747f96ce910a477fe63263da"

