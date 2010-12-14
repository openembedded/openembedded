require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_net_opietooth_applet.tar.bz2;name=split_noncore_net_opietooth_applet \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_net_opietooth_applet.md5sum] = "22d58de01f3920d920b6736c72946021"
SRC_URI[split_noncore_net_opietooth_applet.sha256sum] = "9c113e2aa3c3bc556bd8968328a9ca3c8cfe5cca82f13b6c380b50f7ce8d3cd8"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
