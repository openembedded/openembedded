require ${PN}.inc
PR = "r0"

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_styles_theme.tar.bz2;name=split_noncore_styles_theme \
	http://sources.openembedded.org/opie-1.2.5-split_plugins_styles.tar.bz2;name=split_plugins_styles"
SRC_URI[split_noncore_styles_theme.md5sum] = "c20ee13eb4ab10fe9b8ca1750e112cd9"
SRC_URI[split_noncore_styles_theme.sha256sum] = "a5c478b7001938a5a1250c0a05d56b8cf673df9a2b75726b5ce27264c1170d2d"
SRC_URI[split_plugins_styles.md5sum] = "4d09f3be9e8b904412d368763d974d50"
SRC_URI[split_plugins_styles.sha256sum] = "cecf5695ea1297f899efba863af5e8de6156181ff56e1b4a68fef8289e247446"
