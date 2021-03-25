	.text
	.file	"program.ll"
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	movabsq	$4621819117588971520, %rax # imm = 0x4024000000000000
	movq	%rax, -8(%rsp)
	movabsq	$4648488871632306176, %rax # imm = 0x4082C00000000000
	movq	%rax, -16(%rsp)
	xorl	%eax, %eax
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.section	".note.GNU-stack","",@progbits
