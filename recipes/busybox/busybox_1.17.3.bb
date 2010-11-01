require busybox_1.1x.inc
PR = "${INC_PR}.1"

SRC_URI += "\
  file://busybox-1.17.3-sort.patch  \
  file://busybox-1.17.3-dnsd.patch \
  file://busybox-1.17.3-unicode.patch \
"

SRC_URI[md5sum] = "a2ce1a951571da8c6e0eaf75b1acef60"
SRC_URI[sha256sum] = "de2f0274f61a068d75ad33861e0982e99c6b625681460ce420222371c3511ff2"
