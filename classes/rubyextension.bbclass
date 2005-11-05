DEPENDS  += "ruby-native"
RDEPENDS += "ruby"

rubyextension_do_configure() {
	${STAGING_BINDIR}/ruby setup.rb config || \
	oefatal "ruby setup.rb config stage failed."
}

rubyextension_do_compile() {
	${STAGING_BINDIR}/ruby setup.rb setup || \
	oefatal "ruby setup.rb setup stage failed."
}

rubyextension_do_install() {
	${STAGING_BINDIR}/ruby setup.rb install || \
	oefatal "ruby setup.rb install stage failed."
}

EXPORT_FUNCTIONS do_configure do_compile do_install
