require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_${APPNAME}.tar.bz2;name=split_core_appname \
	   http://sources.openembedded.org/opie-1.2.5-split_core_apps_calibrate.tar.bz2;name=split_core_apps_calibrate \
	   http://sources.openembedded.org/opie-1.2.5-split_core_launcher.tar.bz2;name=split_core_launcher \
	   file://opie-session \
	   file://post-session \
	   file://pre-session \
	   file://opie-login.conf"
SRC_URI[split_core_appname.md5sum] = "88d0bdbc49a59529ce43880f6df82212"
SRC_URI[split_core_appname.sha256sum] = "263a3734c3f9aadacb9d84ff1ae38b717f1eadd66c59c227769a7e26309fb85d"
SRC_URI[split_core_apps_calibrate.md5sum] = "ee5e06b781e92f01271d883f91f101b0"
SRC_URI[split_core_apps_calibrate.sha256sum] = "5e0164a195a166fd15451164edf8a44d8f3a9f81dcf3edc3a8975f24bd4b45b6"
SRC_URI[split_core_launcher.md5sum] = "cd3708a2d074f108d81ffea590995725"
SRC_URI[split_core_launcher.sha256sum] = "fca1501398f1e4d0690455b145b17a68287de422592bca73c2afdf6762d021ce"
