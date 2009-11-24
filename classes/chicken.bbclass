def chicken_arch(bb, d):
    import re
    arch_pattern = re.compile('^i.*86$')
    target_arch = d.getVar("TARGET_ARCH", 1)
    if arch_pattern.match(target_arch):
        return 'x86'
    else:
        return target_arch

CHICKEN_ARCH = "${@chicken_arch(bb, d)}"
    
