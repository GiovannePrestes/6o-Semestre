library verilog;
use verilog.vl_types.all;
entity bitBuffer_vlg_sample_tst is
    port(
        BIT_0_0         : in     vl_logic;
        BIT_0_1         : in     vl_logic;
        BIT_0_2         : in     vl_logic;
        BIT_0_3         : in     vl_logic;
        BIT_1_0         : in     vl_logic;
        BIT_1_1         : in     vl_logic;
        BIT_1_2         : in     vl_logic;
        BIT_1_3         : in     vl_logic;
        BIT_2_0         : in     vl_logic;
        BIT_2_1         : in     vl_logic;
        BIT_2_2         : in     vl_logic;
        BIT_2_3         : in     vl_logic;
        BIT_3_0         : in     vl_logic;
        BIT_3_1         : in     vl_logic;
        BIT_3_2         : in     vl_logic;
        BIT_3_3         : in     vl_logic;
        mem_read        : in     vl_logic;
        Sel_0           : in     vl_logic;
        Sel_1           : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end bitBuffer_vlg_sample_tst;
