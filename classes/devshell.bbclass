EXTRA_OEMAKE[export] = "1"

do_devshell[dirs] = "${S}"
do_devshell[nostamp] = "1"

devshell_do_devshell() {
	export TERMWINDOWTITLE="Bitbake Developer Shell"
	${TERMCMD}
}
addtask devshell after do_patch


EXPORT_FUNCTIONS do_devshell

