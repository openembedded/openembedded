require matchbox-panel.inc

PR ="r12"
SRC_URI = "http://projects.o-hand.com/matchbox/sources/${PN}/0.9/${PN}-${PV}.tar.gz;name=archive \
           file://add_hostap.patch;patch=1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-polling.patch;patch=1;name=patch1 \
           http://handhelds.org/~pb/mb-panel-0.9.2-msgcancel.patch;patch=1;name=patch2 \
           file://mb-applet-battery-repaint.patch;patch=1 \
           file://mb-panel-multi-category-matching.patch;patch=1 \
           file://mb-panel-allow-disabling-menu-panel.patch;patch=1 \
	   file://system-monitor-crash-fix.patch;patch=1 "



SRC_URI[archive.md5sum] = "3122b8d8a796824f9266235b38b0ff1f"
SRC_URI[archive.sha256sum] = "d89d292942e03459f1239e4b3b2e4933aa713f9a606dfe444718f18ff99c7241"
SRC_URI[patch1.md5sum] = "aef0c3abfdd35aefc7f1328204bc337e"
SRC_URI[patch1.sha256sum] = "398484870bc78296c3186776fa7db5abf63036bbe1df674d049edd68d0af7ea8"
SRC_URI[patch2.md5sum] = "61a2f2be6d947618fc0f2e0c93dad6e1"
SRC_URI[patch2.sha256sum] = "320634eacb957779f77a8632b1339276e5d2f7c6877933610250163f6862fc19"
