require ${PN}.inc
PR = "r6"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_apps_calibrate.tar.bz2;name=split_core_apps_calibrate \
           http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_mediummount.tar.bz2;name=split_noncore_settings_mediummount \
           http://sources.openembedded.org/opie-1.2.4-split_core_launcher.tar.bz2;name=split_core_launcher \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps \
           http://sources.openembedded.org/opie-1.2.4-split_root.tar.bz2;name=split_root \
           http://sources.openembedded.org/opie-1.2.4-split_etc.tar.bz2;name=split_etc \
           file://nomax.patch;striplevel=3 \
           file://no-builtin-qss-startup.patch \
           file://kbdlocks-runtime.patch \
           file://restart-from-bindir.patch \
           file://server-pro-1.2.4.patch \
           file://firstuse-path.patch \
           file://force-firstuse-calibrate.patch \
          "
SRC_URI[split_core_apps_calibrate.md5sum] = "daf8aaf7ca9ca16834103586373efe86"
SRC_URI[split_core_apps_calibrate.sha256sum] = "061af18519e45b2e7e87e41b09c10d2baea3b94db8cffc96412290615ef3b3bc"
SRC_URI[split_noncore_settings_mediummount.md5sum] = "a78713d7ed866204f7f3e12ad50851ec"
SRC_URI[split_noncore_settings_mediummount.sha256sum] = "bcb468291ebcdc72059cd5ab467bdedc6a00f9298c23b09da5752f77e569da1f"
SRC_URI[split_core_launcher.md5sum] = "40b7dbd39f79946e32238eed5708fbc8"
SRC_URI[split_core_launcher.sha256sum] = "1813ac4adf8f56ada5b827d2c7950a76e271680f544edfe1a17c92e7bd0bc632"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
SRC_URI[split_root.md5sum] = "5d2f707b17e00cad32e8eacc1641cf10"
SRC_URI[split_root.sha256sum] = "7b543d57f908b76a53270fd4b0df0a60a0863eca32adb2eb5815a3f1a279d9d6"
SRC_URI[split_etc.md5sum] = "ed2c78e9ce1525da1f4e262528956fb8"
SRC_URI[split_etc.sha256sum] = "ca2819a56531086ec917f7cd560b8a395dd9c2b10dd996adad5deb64fcd3a537"
