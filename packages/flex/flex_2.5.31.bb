BROKEN_arm="1"

# On ARM I got:
#
# tables.c: In function `yytbl_write16':
# tables.c:313: internal compiler error: in arm_print_operand, at config/arm/arm.c:11410

include flex.inc
PR = "r1"
