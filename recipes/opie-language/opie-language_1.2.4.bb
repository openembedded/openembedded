require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_language.tar.bz2;name=split_noncore_settings_language \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_settings_language.md5sum] = "3dd458816f20f8bb6255a17f9941bb2e"
SRC_URI[split_noncore_settings_language.sha256sum] = "9082c14ccc338e5b6a061e0cd2a556e71cff16b37b2b7605bbd56332cb428f7d"
SRC_URI[split_apps.md5sum] = "67a43e8e4bcd9e63b884ea25deea5b34"
SRC_URI[split_apps.sha256sum] = "a33a55efb4ae4c15a8c2c5d6faba6d671a5652da8e216ce35088896fe597215b"
