Feature: Testing SauceDemo Website

  @Positive
  Scenario: Login dengan data yang valid
    Given User dalam halaman login SauceDemo
    When User memasukan usernam dan password yang terdaftar
    And User menekan tombol login
    Then User berhasil login di halaman katalog produk

  @Negative
  Scenario: Login dengan data yang tidak valid
    Given User dalam halaman login SauceDemo
    When User enters invalid username and password
    And User menekan tombol login
    Then User melihat pesan error

  @Positive
  Scenario: Menambahkan item kedalam cart
    Given User telah login kedalam website SauceDemo
    When User menambahkan beberapa item kedalam cart
    Then Keranjang user harus memiliki item yang di pilih

  @Positive
  Scenario: Menyelesaikan pembelian
    Given User telah login kedalam website SauceDemo
    When User melakukan proses checkout
    And User memasukkan alamat pengiriman
    And User completes the purchase
    Then User harus melihat notifikasi order pesanan berhasil