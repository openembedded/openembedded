require libxml2.inc

SRC_URI += "\
  file://0cbeb50ee03ce582a0c979c70d8fbf030e270c37.patch \
  file://df83c17e5a2646bd923f75e5e507bc80d73c9722.patch \
  file://fec31bcd452e77c10579467ca87a785b41115de6.patch \
  file://00819877651b87842ed878898ba17dba489820f0.patch \
"

PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "8127a65e8c3b08856093099b52599c86"
SRC_URI[archive.sha256sum] = "cda23bc9ebd26474ca8f3d67e7d1c4a1f1e7106364b690d822e009fdc3c417ec"
