library verilog;
use verilog.vl_types.all;
entity mem_4x16_vlg_sample_tst is
    port(
        bit_0           : in     vl_logic;
        bit_1           : in     vl_logic;
        bit_2           : in     vl_logic;
        bit_3           : in     vl_logic;
        Mem_Read        : in     vl_logic;
        Mem_write       : in     vl_logic;
        Sel_0           : in     vl_logic;
        Sel_1           : in     vl_logic;
        Sel_2           : in     vl_logic;
        Sel_3           : in     vl_logic;
        sampler_tx      : out    vl_logic
    );
end mem_4x16_vlg_sample_tst;
