include sdcc_${PV}.bb

inherit native

# yes, we usually don't want to do this in order to prevent staging pollution,
# however sdcc behaves pretty nice here, so we can do an exception here (ML).
do_stage() {
	oe_runmake install 
}

