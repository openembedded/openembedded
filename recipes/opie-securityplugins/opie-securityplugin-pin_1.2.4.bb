require opie-securityplugin-pin.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_securityplugins_pin.tar.bz2;name=split_noncore_securityplugins_pin \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_securityplugins_pin.md5sum] = "84a5bfff5aeb7bee78fb23c7c2ad7361"
SRC_URI[split_noncore_securityplugins_pin.sha256sum] = "63deecb6b8d3154e46a44ebecffa264196cbf065c33423f8cbbf77c2d656c97a"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"

